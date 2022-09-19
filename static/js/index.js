// create the Vue controller
const app = Vue.createApp();

// import the navigation menu
import { navigationMenu } from './nav-menu.js';

// register the navigation menu under the <navmen> tag
app.component('navmen', navigationMenu);

// attach the controller to the <main> tag
app.mount("main");
