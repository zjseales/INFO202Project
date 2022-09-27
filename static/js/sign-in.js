var customerApi = ({username}) => `/api/customers/${username}`;

const app = Vue.createApp({

    data() {
        return {
            // models map (comma separated key/value pairs)
        };
    },

    mounted() {
        // semicolon separated statements

    },

    methods: {
        // comma separated function declarations
        
        // Currently login by username, (no password authentication)
        login(username) {

            axios.get(customerApi({'username':username}))
                .then(response => {
                    dataStore.commit('signIn', response.data);
                    window.location = 'browse.html';
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

import { dataStore } from './data-store.js';
app.use(dataStore);

// mount the page - this needs to be the last line in the file
app.mount("main");
