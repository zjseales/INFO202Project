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
        <div class="font6" v-if="signedIn">--- Welcome {{customer.firstName}} ---</div>
        <p></p>
        <a class="font2" href="index.html">Home</a>
        <a class="font2" href="browse.html" v-if="signedIn">Browse Products</a>
        <a class="font2" href="view-cart.html" v-if="signedIn">View Cart</a>
        <a class="font2" href="#" v-if="signedIn" @click="signOut()">Sign Out</a>
        <a class="font2" href="create-account.html" v-if="!signedIn">Create Account</a>
        <a class="font2" href="sign-in.html" v-if="!signedIn">Sign In</a>
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

