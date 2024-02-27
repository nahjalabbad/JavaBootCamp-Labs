import java.util.ArrayList;
import java.util.List;

class User {
    private String username;
    private String email;
    private List<Media> purchasedMediaList;
    private List<Media> shoppingCart;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.purchasedMediaList = new ArrayList<>();
        this.shoppingCart = new ArrayList<>();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Media> getPurchasedMediaList() {
        return purchasedMediaList;
    }

    public void addToCart(Media media) {
        shoppingCart.add(media);
        System.out.println("Added '" + media.getTitle() + "' to the shopping cart.");
    }

    public void removeFromCart(Media media) {
        shoppingCart.remove(media);
        System.out.println("Removed '" + media.getTitle() + "' from the shopping cart.");
    }

    public void checkout() {
        purchasedMediaList.addAll(shoppingCart);
        shoppingCart.clear();
    }

        public void setPurchasedMediaList (List < Media > purchasedMediaList) {
            System.out.println("Purchased Media:");
            int count = 0;
            for (Media media : purchasedMediaList) {
                if (count < 5) {
                    System.out.println(media.getTitle());
                    count++;
                } else {
                    break;
                }
            }
            if (purchasedMediaList.size() > 5) {
                System.out.println("And " + (purchasedMediaList.size() - 5) + " more items...");
            }

        }


        public List<Media> getShoppingCart () {
            return shoppingCart;
        }

        public void setShoppingCart (List < Media > shoppingCart) {
            this.shoppingCart = shoppingCart;
        }


}
