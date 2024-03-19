import { app } from "./app.js";
import { HeaderComponent } from "./components/header-component/header-component.js";
import { SidebarComponent } from "./components/sidebar-component/sidebar-component.js";

addEventListener("DOMContentLoaded", async (e) => {
    await app();
})