import { routes } from "../../util/Routes.js";

const pathItemsJson = "../components/sidebar-component/items-sidebar-component.json";

const navItems = async (jsonFilePath) => {
  try {
    const data = await (await fetch(jsonFilePath)).json();
    const navItems = data['nav-items'];
    const navItemsHTML = navItems.map((e) => {
      const { "nav-link": { icon, text, href, query } } = e;

      let listItemsHTML = '';
      if (typeof query === 'number' && query > 0) {
        for (let i = 1; i <= query; i++) {
          listItemsHTML += /*html */`
          <li id="query" class="nav-item" data-type="${text.toLowerCase()}" data-query-number="${i}">
            <a class="nav-link text-white">
              <i class="fa-solid fa-arrow-right px-2"></i>
              <p>Query ${i}</p>
            </a>
          </li>
          `;
        }
      }

      return /*html*/`
      <div class="accordion-item bg-transparent my-2">
        <h2 class="accordion-header">
          <button class="accordion-button collapsed bg-transparent text-white fw-semibold" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse${text.toLowerCase()}" aria-expanded="false" aria-controls="flush-collapseOne">
              <p class="ms-3 w-25">${icon}</p>
              <p class="brand-text ms-3 w-100">${text}</p>
          </button>
        </h2>
        <div id="flush-collapse${text.toLowerCase()}" class="accordion-collapse collapse m-0" data-bs-parent="#accordionFlush">
          <div class="accordion-body">
          ${listItemsHTML}
          </div>
        </div>
      </div>
  `;
    });
    return navItemsHTML.join('');
  } catch (error) {
    console.error('Cannot Read Items Components:', error);
    return '';
  }
};

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

  async render() {
    this.username = this.getAttribute('username') || 'Usuario';
    await navItems(pathItemsJson)
      .then((items) => {
        this.innerHTML = /*html*/`
        <aside class="main-sidebar sidebar-dark bg-navy accent-white min-vh-100">
            <!-- Brand Logo -->
            <a href="${routes.home}" class="brand-link">
              <img src="../../assets/img/growMartLogo.png" alt="Libreria Logo" class="brand-image img-circle">
              <span class="brand-text h4"><b>Grow</b>Mart</span>
            </a>

            <!-- Sidebar -->
            <div class="sidebar">
              <!-- Sidebar user panel -->
              <div class="user-panel ps-2 py-3 d-flex align-items-center">
                  <div class="image w-25">
                      <i class="nav-icon fas fa-user"></i>
                  </div>
                  <div class="info">
                      <a class="d-block fw-semibold w-100">${this.username}</a>
                  </div>
              </div>
              <!-- Sidebar Menu -->
              <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                  ${items}
                </ul>
              </nav>
              <!-- /.sidebar-menu -->
            </div>
            <!-- /.sidebar -->
      </aside>
        `
      });
  }
}

customElements.define("main-sidebar-component", SidebarComponent)