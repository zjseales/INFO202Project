// create the Vue controller
const app = Vue.createApp();

// import the navigation menu
import { navigationMenu } from './navigation-menu.js';

// register the navigation menu under the <navmen> tag
app.component('navmen', navigationMenu);

// import data store
import { dataStore } from './data-store.js'
app.use(dataStore);

// attach the controller to the <main> tag
app.mount("main");
