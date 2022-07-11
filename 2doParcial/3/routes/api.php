<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Models\Cliente;
use App\Http\Controllers\PersonaController;
use App\Http\Controllers\UserController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

// Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
//     return $request->user();
// });

Route::post('login', [UserController::class, 'authenticate']);


Route::group(['middleware' => ['jwt.verify']], function () {
    Route::get('personas', [PersonaController::class, 'index']);
    Route::get('personas/{id}', [PersonaController::class, 'show']);
    Route::post('personas', [PersonaController::class, 'store']);
    Route::put('personas/{id}', [PersonaController::class, 'update']);
    Route::patch('personas/{id}', [PersonaController::class, 'update']);
    Route::delete('personas/{id}', [PersonaController::class, 'destroy']);
});
