# Библиотечное WEB CRUD приложение

# Используемые технологии
Maven
Spring MVC
Thymeleaf
Tomcat
PostgreSQL
Hybernate

# Структура базы данных
В базе данных предусмотрены все возможные проверки значений **Check**,
а так же проверки на **NULL**
все **Foreign key** удаляется через **Cascade**

<img src="./readme_files/db_structure.png" alt="alt text" width="700"/>

Для быстродействия используются **View**

<img src="./readme_files/author_view.png" alt="alt text" width="200"/>

# WEB приложение кратко
В приложении есть все атрибуты **CRUD**
Можно просматривать, создавать, редактировать и удалять сущности.

**Скриншоты страниц:**

**Клиенты библиотеки**

Пример страницы со списком всех клиентов библиотеки

<img src="./readme_files/clients_list.png" alt="alt text" width="500"/>

Если нажать на любую строку в списке клиентов, то мы перейдем на страницу клиента
Здесь есть кнопки управления этим клиентом, например можно его изменить

<img src="./readme_files/client_page.png" alt="alt text" width="400"/>

Страница с добавлением нового клиента. Все поля дважды проверяются,
сначала средствами Базы данных **Check** и другие ограничения,
затем с помощью Hybernate Validator

<img src="./readme_files/add_client.png" alt="alt text" width="400"/>

Точно такой же функционал, как и с клиентами есть у книг, авторов и аренды

**Книги**

<img src="./readme_files/books_list.png" alt="alt text" width="500"/>

При добавлении кинги есть удобные списки, которые оторажают список существующих авторов.

<img src="./readme_files/add_book.png" alt="alt text" width="400"/>

Затем эти значения подставляются в базу данных.

<img src="./readme_files/add_book_controller.png" alt="alt text" width="600"/>

Для удобства, используется шаблонизатор Thymeleaf

<img src="./readme_files/add_book_controller_selection.png" alt="alt text" width="600"/>


**Аренда**

<img src="./readme_files/rents_list.png" alt="alt text" width="500"/>
