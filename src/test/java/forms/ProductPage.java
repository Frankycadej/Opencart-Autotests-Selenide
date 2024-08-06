package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    public class macBookProduct {
        public SelenideElement
                addToCartMbBtn = $x(""),
                itemsCostBtn = $x("N item(s) - $0.00"),
                viewCartBtn = $x("View Cart"); //general
    }
    public class iphoneProduct {

        public SelenideElement
                addToWishListBtn = $x("Add to Wish List"),
                wishlistBtn = $x("Wish List");
    }
}

