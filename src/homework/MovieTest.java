package homework;

/**
 * 模拟3个人排除买票，每人买1张票。售货员只有1张五元的钱，
 * 电影票5元一张，王大拿拿一张二十元的人民币排在谢大脚前面买票，
 * 谢大脚拿1张十元的人民币排在在赵四的前面买票，赵四拿1张五元的人民币排在最后。
 * 即最终的卖票次序是：谢大脚、赵四、王大拿
 */
public class MovieTest {
    public static void main(String[] args) throws InterruptedException {
        Sale sale = new Sale();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    sale.sale3(5);
                }

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    sale.sale(20);
                }


            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    sale.sale2(10);

                }

            }
        }.start();


    }
}
class Sale {
    int change = 5;//售货员零钱
    int sales = 5;//电影票价
    int flag = 1;//排队顺序线程执行方法顺序
    int arr[] = new int[3];
    public synchronized void sale(int money){
        if (flag != 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if (money == sales + change) {
            System.out.println("甲买到票");
            change = money;
            flag  = 2;
            notifyAll();

        }else if (money == sales){
            System.out.println("甲买到票");
            change = money +sales;

            flag = 2;
            notifyAll();

        }else {
            try {
                flag = 2;
                notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void sale2(int money) {
        if (flag != 2) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if (money == sales + change) {
            System.out.println("乙买到票");

            change = money;
            flag  = 3;
            notifyAll();

        }else if (money == sales){
            System.out.println("乙买到票");
            change = money +sales;
            flag = 3;
            notifyAll();

        }else {
            try {
                flag = 3;
                notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public synchronized void sale3(int money) {
        if (flag != 3) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if (money == sales + change) {
            System.out.println("丙买到票");
            change = money;
            flag  = 1;
//            notifyAll();

        }else if (money == sales){
            System.out.println("丙买到票");
            change = money +sales;

            flag = 1;
            notifyAll();

        }else {
            System.out.println();
        }
    }
}
class Practice {
    public static void main(String[] args) {
        TicketSeller seller = new TicketSeller();

        TicketThread t1= new TicketThread(seller, 5);
        TicketThread t2= new TicketThread(seller, 10);
        TicketThread t3= new TicketThread(seller, 20);

        t1.setName("赵四");
        t2.setName("谢大脚");
        t3.setName("王大拿");
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();


    }
}

/**
 * 买票线程，创建3个，模拟三人买票
 */
class TicketThread extends Thread{
    private TicketSeller seller;
    private int money;

    public TicketThread(TicketSeller seller, int money) {
        this.seller = seller;
        this.money = money;
    }

    @Override
    public void run() {
        seller.buyTicket(money);
    }
}

/**
 * 售票员，模拟售票可能遇到的3种情况
 */
class TicketSeller {
    private int fiveAcount = 1, tenAcount = 0, twentyAcount = 0;

    public synchronized void buyTicket(int receiveMoney) {
        //收到5元
        if (receiveMoney == 5) {
            System.out.println(Thread.currentThread().getName()+"付钱5元，不用找钱");
            fiveAcount++;
        }
        //收到10元
        else if(receiveMoney== 10){
            //没有5元现金，需要让10元客户等待，
            while (fiveAcount<1){
                System.out.println(Thread.currentThread().getName()+"付钱10元，现在没有零钱，请等待");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //有5元零钱，进行操作
            System.out.println(Thread.currentThread().getName()+"付了10元"+"找给"+Thread.currentThread().getName()+"5元");
            fiveAcount--;
            tenAcount++;
        }
        //收到20元
        else {
            //没有同时拥有5元和10元
            while (fiveAcount<1 || tenAcount<1){
                System.out.println(Thread.currentThread().getName()+"付钱20元，现在没有零钱，请等待");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //同时拥有5元和10元，可以给20元找零
            System.out.println(Thread.currentThread().getName()+"付了20元"+"找给"+Thread.currentThread().getName()+"15元");
            twentyAcount++;
            fiveAcount--;
            tenAcount--;
        }
        //卖票成功，通知其他人刷新状态，判断是否仍需等待。
        notifyAll();
    }
}
