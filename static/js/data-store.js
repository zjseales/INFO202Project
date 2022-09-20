export const dataStore = Vuex.createStore({

    // Session state values
    state () {
        
        // signed in customer
        customer: null;
        // the shopping cart items
        items: null;
        // the product being selected by the customer
        selectedProduct: null;
    },

    // Functions that modify session state
    mutations: {

        // user signs in
        signIn(state, customer) {
            state.customer = customer;
            state.items = new Array();
        },
        
        //user selects a product
        selectProduct(state, product){
            state.selectedProduct = product;
        }

    },

    // add session storage persistence
    plugins: [window.createPersistedState({storage: window.sessionStorage})]

});
