const expect = require('chai').expect;

describe('Shopping cart', () => {
  it('should add a product to cart and remove it', () => {
    browser.url('/dev');

    $('.shelf-item').waitForDisplayed();
    $('.bag__quantity').waitForDisplayed();

    /* Open float cart */
    $('.bag--float-cart-closed').click();
    browser.pause(200); //wait for animation

    /* Bag should start with 0 products */
    expect($('.bag__quantity').getText()).to.equal('0');

    /* Add a product to cart */
    $('.shelf-item').click();
    /* And it should have 1 product in it now */
    expect($('.bag__quantity').getText()).to.equal('1');

    /* Add again -> 2 */
    $('.shelf-item').click();
    expect($('.bag__quantity').getText()).to.equal('2');

    /* Remove the product from cart and now it should show 0 products in bag */
    $('.shelf-item__del').click();
    expect($('.bag__quantity').getText()).to.equal('0');
  });
});
