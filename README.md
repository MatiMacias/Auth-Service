<h1>Auth Service</h1>

<p>Servicio de autenticación basado en <strong>Spring Boot + Spring Security + JWT</strong>,
  diseñado como backend stateless para aplicaciones web o mobile.</p>

<p>Este proyecto implementa el flujo completo de <strong>registro</strong>,
  <strong>login</strong> y <strong>protección de endpoints</strong> mediante JSON Web Tokens.</p>

<hr />

<h2>Características</h2>
<ul>
  <li>Registro de usuarios con contraseña encriptada (BCrypt)</li>
  <li>Login con validación contra base de datos</li>
  <li>Generación de JWT firmados (HS256)</li>
  <li>Autenticación stateless</li>
  <li>Protección de endpoints con Spring Security moderno (SecurityFilterChain)</li>
  <li>Persistencia con JPA + Hibernate</li>
  <li>Base de datos MySQL</li>
</ul>

<hr />

<h2>Stack tecnológico</h2>
<ul>
  <li>Java 17</li>
  <li>Spring Boot 4.x</li>
  <li>Spring Security</li>
  <li>Spring Data JPA</li>
  <li>Hibernate</li>
  <li>JWT (jjwt)</li>
  <li>MySQL</li>
  <li>Maven</li>
</ul>

<hr />

<h2>Estructura general</h2>
<ul>
  <li><code>auth</code> – Endpoints públicos (register / login)</li>
  <li><code>api</code> – Endpoints protegidos por JWT</li>
  <li><code>security</code> – Configuración de Spring Security y filtro JWT</li>
  <li><code>user</code> – Entidad, repositorio y UserDetailsService</li>
</ul>

<hr />

<h2>Flujo de autenticación</h2>
<ol>
  <li>
    <strong>Register</strong>
    <ul>
      <li>Se crea un usuario</li>
      <li>La contraseña se guarda encriptada</li>
    </ul>
  </li>
  <li>
    <strong>Login</strong>
    <ul>
      <li>Se validan las credenciales</li>
      <li>Se genera un JWT con los claims <code>sub</code>, <code>role</code>, <code>iat</code> y <code>exp</code></li>
    </ul>
  </li>
  <li>
    <strong>Acceso a endpoints protegidos</strong>
    <ul>
      <li>El cliente envía el token en el header:</li>
    </ul>
    <pre>Authorization: Bearer &lt;JWT&gt;</pre>
  </li>
</ol>

<hr />

<h2>Endpoints</h2>

<h3>Públicos</h3>

<h4>Register</h4>
<pre>POST /auth/register</pre>
<pre>{
  "username": "user",
  "password": "1234",
  "email": "user@mail.com
}</pre>

<h4>Login</h4>
<pre>POST /auth/login</pre>
<pre>{
  "username": "user",
  "password": "1234"
}</pre>

<p>Respuesta:</p>
<pre>{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}</pre>

<hr />

<h3>Protegidos</h3>

<h4>Ejemplo</h4>
<pre>GET /api/hello</pre>
<pre>Authorization: Bearer &lt;JWT&gt;</pre>

<hr />

<h2>Configuración</h2>

<h3>Base de datos</h3>
<pre>
spring.datasource.url=jdbc:mysql://localhost:3306/auth_db
spring.datasource.username=YOUR_USER
spring.datasource.password=YOUR_PASSWORD
</pre>

<hr />

<h2>Pruebas</h2>
<p>Los endpoints pueden probarse con Postman o Insomnia siguiendo el flujo:</p>
<ol>
  <li>Register</li>
  <li>Login (obtener token)</li>
  <li>Acceder a endpoints protegidos usando el token</li>
</ol>

<hr />

<h2>Estado del proyecto</h2>
<ul>
  <li>Registro funcional</li>
  <li>Login funcional</li>
  <li>JWT funcional</li>
  <li>Seguridad stateless implementada</li>
</ul>

<p>Este proyecto representa una base sólida y completa para un sistema de autenticación moderno.</p>

<hr />

<h2>Autor</h2>
<p>Desarrollado por Matías Macías 🇦🇷 Developer</p>
<p>Proyecto creado con fines educativos y como parte de un portfolio profesional.</p>
