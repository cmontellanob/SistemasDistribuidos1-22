## Añadir Seguridad JWT al Proyecto
# Instalar la libreria
composer require firebase/php-jwt
# Generar elarchivo de Middleware
php artisan make:middleware JWTMiddleware
# Agregar el Middleware al archivo de configuracion
En el archivo app\http\Kernel.php  en la seccion protected $routeMiddleware agregar:

'jwt.verify' => \App\Http\Middleware\JWTMiddleware::class,
# Proteger Rutas 
todas las rutas que se quiera proteger se debe incluir en api.php 

['middleware' => ['jwt.verify']



