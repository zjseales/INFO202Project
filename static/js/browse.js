var productsApi = "/api/products/"
var categoriesApi = "/api/categories/"
var categoriesFilterApi = ({category}) => `/api/categories/${category}`;

const app = Vue.createApp({

    data() {
        return {
            // models map (comma separated key/value pairs)
            products: new Array(),
            categories: new Array()
        };
    },
    
   computed: Vuex.mapState({
      customer: 'selectCustomer',
   }),
    
    mounted() {
        //retrieve all products and categories on page startup 
        this.getProducts();
        this.getCategories();
    },

    methods: {
        // (comma separated function declarations)
        
        // Retrieves all products
        getProducts() {
            axios.get(productsApi)
                .then(response => {
                    this.products = response.data;
                })
                .catch(error => {
                    alert(error.response.data.message);
                });
        },
        
        //retrieve all categories
        getCategories() {
            axios.get(categoriesApi)
                .then(response => {
                    this.categories = response.data;
                })
                .catch(error => {
                    alert(error.response.data.message);
                });
        },
        
        // click handler for the category filter buttons
	filterByCategory(category) {
            axios.get(categoriesFilterApi({'category':category}))
            .then(response => {
                this.products = response.data;
            })
            .catch(error => {
                console.error(error);
                alert("An error occurred - check the console for details.");
            });
	},
    },

    // other modules
    mixins: []

});

// other component imports go here

// import the navigation menu
import { navigationMenu } from './nav-menu.js';
// register the navigation menu under the <navmen> tag
app.component('navmen', navigationMenu);

import { sessionStore } from './session-store.js';
app.use(sessionStore);  

// mount the page - this needs to be the last line in the file
app.mount("main");
