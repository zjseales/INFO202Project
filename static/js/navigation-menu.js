"use strict";

export const navigationMenu = { 
    
    computed: {
        signedIn() {
            return this.customer != null;
        },
        
        ...Vuex.mapState({
            customer: 'customer'
        })
    },

    template:
    `
    <nav>
        <div v-if="signedIn">Welcome {{customer.firstName}}</div>
        <p></p>
        <a href="index.html">Home</a>
        <a href="browse.html" v-if="signedIn">Browse Products</a>
        <a href="view-cart.html" v-if="signedIn">View Cart</a>
        <a href="#" v-if="signedIn" @click="signOut()">Sign Out</a>
        <a href="create-account.html" v-if="!signedIn">Create Account</a>
        <a href="sign-in.html" v-if="!signedIn">Sign In</a>
        <p></p>
    </nav>
    `,

    methods:{
        signOut() {
            sessionStorage.clear();
            window.location = '.';
        }
    }
};

