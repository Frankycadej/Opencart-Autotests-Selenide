package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WishListPage {

    public SelenideElement
            continueBtn = $x("//div[@class='text-end']/a"),
            emptyWishList = $x("//div[@id='wishlist']/p"),
            iphoneInWishList = $x("//td[@class='text-start']/a[contains(@href,'iphone')]"),
            removeProduct = $x("//i[@class='fa-solid fa-circle-xmark fa-fw']/.."); //button[@aria-label='Remove']
}
