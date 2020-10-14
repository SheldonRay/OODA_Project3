class StoreSim {
  Store store;
  CustomerFactory factory = new CustomerFactory();//A CLASS THAT HAS THE PRODUCTS OF THE FACTORY

  int day = 1;

  public static void main(String args[]) {
    this.store = new Store(1);
    for(day; day <= 30; day++) {
      System.out.println(day);
    }
  }
}
