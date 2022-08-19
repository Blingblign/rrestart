package homework;

/**
 * 生产者消费者问题
 * 设有一个最大库存量为4的电视机仓库，生产10台电视机，一边生产一边销售（消费）。
 */
public class ProductConsumerTest {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Product product = new Product(storage);
        Consumer consumer = new Consumer(storage);
        product.start();
        consumer.start();
    }
}
class Storage {
    final int Max_Storage = 4;//最大库存量
    int product = 0;//库存数
    int sumProduct;//总生产数
    int sumConsume;//总消费数
    public synchronized void setProduct(){
        if (product >= 4) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产者生产，库存电视机台数为" + ++product);
        sumProduct++;
        notify();
    }
    public synchronized void consume() {
        if(product <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者消费，库存电视机台数为" + --product);
        sumConsume++;
        notify();
    }

}
class Product extends Thread {
    private Storage storage;

    public Product(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (storage.sumProduct < 10) {
            storage.setProduct();
        }
    }
}
class Consumer extends Thread {
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (storage.sumConsume < 10) {
            storage.consume();
        }
    }
}

