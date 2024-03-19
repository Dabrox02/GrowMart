import { routes } from "../../util/Routes.js";

export class SidebarComponent extends HTMLElement {

  constructor() {
    super();
    this._observer = new MutationObserver(this.attributeChangedCallback.bind(this));
  }

  disconnectedCallback() {
    this._observer.disconnect();
  }

  attributeChangedCallback(attributeName, oldValue, newVdalue) {
    this.render();
  }

  connectedCallback() {
    this._observer.observe(this, { attributes: true });
  }

  render() {
    this.username = this.getAttribute('username') || 'Usuario';

    this.innerHTML = /*html*/`
        <aside class="main-sidebar sidebar-dark bg-navy accent-white min-vh-100">
        <!-- Brand Logo -->
        <a href="${routes.home}" class="brand-link">
          <img src="https://img.icons8.com/?size=256&id=12KiRC81sMRC&format=png" alt="Libreria Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
          <span class="brand-text h4"><b>Grow</b>Mart</span>
        </a>
  
        <!-- Sidebar -->
        <div class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel ps-2 py-3 d-flex align-items-center">
            <div class="image">
            <i class="nav-icon fas fa-user"></i>
            </div>
            <div class="info">
              <a class="d-block fw-semibold">${this.username}</a>
            </div>
          </div>
  
          <!-- Sidebar Menu -->
          <nav class="mt-2">
            <ul class="nav nav-pill nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
            <li class="nav-item">
                <a href="${routes.home}" class="nav-link text-white">
                  <i class="nav-icon fas fa-th"></i>
                  <p> Inicio </p>
                </a>
              </li>
            </ul>
          </nav>
          <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
      </aside>
        `
  }

}

customElements.define("main-sidebar-component", SidebarComponent)