var customersApi = '/api/register/';

const app = Vue.createApp({

    data() {
        return {
            // models map (comma separated key/value pairs)
            customer: new Object()
        };
    },

    mounted() {
        // semicolon separated statements

    },

    methods: {
        // comma separated function declarations
        
        createAccount() {
            axios.post(customersApi, this.customer)
                .then(() => {
                    window.location = 'index.html';
                })
                .catch(error => {
                    alert(error.response.data.message);
                });
        }

    },

    // other modules
    mixins: []

});

// other component imports go here
// 
// import the navigation menu
import { navigationMenu } from './navigation-menu.js';
// register the navigation menu under the <navmen> tag
app.component('navmen', navigationMenu);

// import data store
import { dataStore } from './data-store.js'
app.use(dataStore);

// mount the page - this needs to be the last line in the file
app.mount("main");
