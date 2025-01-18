Feature: Search and Place the order for Products

@OffersPage
Scenario Outline: Search Experience for product search in both home and offers page

Given Verify User is on Greencart landing page
When user searches with shortname <ProductName> and extracted actual name of product
Then user searched for same shortname <ProductName> in offers page
And Validate product name in offers page matches with landing page
And Test4
And Test5
Examples:

| ProductName |
| Tom |
| Beet |

