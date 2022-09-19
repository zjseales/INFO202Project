export const sessionStore = Vuex.createStore({

    state () {
        selectCustomer: null;
    },

    mutations: {

        selectCustomer(state, customer) {
            state.selectCustomer = customer;
        }

    },

    plugins: [window.createPersistedState({storage: window.sessionStorage})]

});


