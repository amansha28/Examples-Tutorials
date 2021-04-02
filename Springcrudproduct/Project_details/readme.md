-- This is a simple demo example of Spring CRUD app.
The working of this project is as follows	
1) It contains a simple JSP form (/home) which displays the list of products already added.
2) From the /home page we can click on "Add Product" button to add a new Product.
3) From the /home page we can click on the "Pencil" icon, corresponding to a specific product to update it details.
	3.1) This will take you to /update-product page where we can update details and click "Save" to persist the changes.
	3.2) OR click on the "Cancel" button to cancel the changes to the product details
4) From the /home page we can clikc on the "Trash bin" icon, corresponding to a specific product to delete it.

----------------
Features : 
1) It uses H2 in-memory database to maintain the records.
2) Auto populates few entries, to get things going for demo purpose.
3) It has the feature that default entries will be added only once when the product is run for the first time. Post that until the H2 database is wiped clean the details will be there.
