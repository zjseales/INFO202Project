"use strict";

var salesApi = "/api/sales/"

class SaleItem {
    constructor(product, quantityPurchased) {
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.salePrice = product.listPrice;
    }
}

class Sale {
    constructor(customer, items) {
        this.customer = customer;
        this.items = items;
    }
}

const app = Vue.createApp({

    data() {
        return {
            // models (comma separated key/value pairs)
        };
    },

    computed: Vuex.mapState({
        product: 'selectedProduct',
        items: 'items',
        customer: 'customer'
    }),


    mounted() {
        // semicolon separated statements
    },

    methods: {
        // comma separated function declarations
        
        // add item to cart and redirect back to store
        addToCart(product, quantity){
            if (quantity <= product.quantityInStock && quantity > 0){
                dataStore.commit("addItem", new SaleItem(product, quantity));
                window.location = 'browse.html';
            } else {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
                alert("Amount being purchased must be a positive number\nless than, or equal to, the Quantity of Stock");
            }
        },
        
        // Finalize sale of cart items
        checkOut() {
            let sale = new Sale(this.customer, this.items);
            axios.post(salesApi, sale)
                .then(() => {
                    dataStore.commit("clearItems");
                    window.location = 'confirmation.html';
                })
                .catch(error => {
                    alert(error.response.data.message);
                });
        }
    }

});

// import the navigation menu
import { navigationMenu } from './navigation-menu.js';
// register the navigation menu under the <navmen> tag
app.component('navmen', navigationMenu);

// import data store
import { dataStore } from './data-store.js';
app.use(dataStore); 

// mount the page - this needs to be the last line in the file
app.mount("main");
