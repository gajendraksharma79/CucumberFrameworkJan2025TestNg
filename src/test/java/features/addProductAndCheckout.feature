Feature: Plase the order for Products

@PlaceOrder
Scenario: Verify by search, add, enter quantity and checkout a product

Given Verify User is on Greencart landing page
When user searches with shortname Tom and extracted actual name of product
And enters quantity as 4 and adds to the cart
And Proceeds to checkout page
Then user verifies same product displays on checkout page
And Validate Apply button is visible
And Validate Place Order button is visible
And Validate GreenKart logo is visible
