//Made by Sheldon Ray, Tyler Devlin, Jacob Reynolds
//08/12/2020


private class Store {
    private int storeID = 0;
    private int totalEggOrders = 0;
    private int totalSpringOrders = 0;
    private int totalPastryOrders = 0;
    private int totalSausageOrders = 0;
    private int totalJellyOrders = 0;
    private int totalSales = 0;
    private int totalOutages = 0;

    public EggRolls eggRolls = new EggRolls();
    public SpringRolls springRolls = new SpringRolls();
    public PastryRolls pastryRolls = new PastryRolls();
    public SausageRolls sausageRolls = new SausageRolls();
    public JellyRolls jellyRolls = new JellyRolls();
    public Store(int storeID) {
      this.storeID = storeID;
    }
    public int getTotalOrders() {
      return totalEggOrders + totalSpringOrders + totalPastryOrders + totalSausageOrders + totalJellyOrders;
    }
    public int getTotalEggOrders() {
      return totalEggOrders;
    }
    public int getTotalSpringOrders() {
      return totalSpringOrders
    }
    public int getTotalPastryOrders() {
      return totalPastryOrders;
    }
    public int getTotalSausageOrders() {
      return totalSausageOrders;
    }
    public int getTotalJellyOrders() {
      return totalJellyOrders;
    }
    public int getTotalSales() {
      return totalSales;
    }
    public int getTotalOutages() {
      return totalOutages;
    }
    public void printInventory() {
      System.out.println(eggRolls.inventory + " egg rolls in inventory");
      System.out.println(springRolls.inventory + " spring rolls in inventory");
      System.out.println(pastryRolls.inventory + " pastry rolls in inventory");
      System.out.println(sausageRolls.inventory + " sausage rolls in inventory");
      System.out.println(jellyRolls.inventory + " jelly rolls in inventory");
    }
    public int takeOrder() {

    }
}
