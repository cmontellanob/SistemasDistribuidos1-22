<?php

namespace App\Http\Controllers;

use Firebase\JWT\JWT;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use App\Models\User;

class UserController extends Controller
{

    public function authenticate(Request $request)
    {
        $usuario = $request->usuario;
        $password = $request->password;

        if ($usuario = "usuario" && $password == "123") {
            $key = env('JWT_SECRET', '');
            $time = time();
            $token = array(
                'iat' => $time, // Tiempo que inició el token
                'exp' => $time + (1200 * 60), // Tiempo que expirará el token (+1 hora)
                'data' => [ // información del usuario

                    'rol' => 'usuario',
                ]
            );
            $jwt = JWT::encode($token, $key, 'HS256');
            return response()->json([
                'success' => true,
                'token' => $jwt,
            ]);
        }
        if ($usuario = "admin" && $password == "456") {
            $key = env('JWT_SECRET', '');
            $time = time();
            $token = array(
                'iat' => $time, // Tiempo que inició el token
                'exp' => $time + (1200 * 60), // Tiempo que expirará el token (+1 hora)
                'data' => [ // información del usuario

                    'rol' => 'admin',
                ]
            );
            $jwt = JWT::encode($token, $key, 'HS256');
            return response()->json([
                'success' => true,
                'token' => $jwt,
            ]);
        }
        return response()->json([
            'success' => false,
            'message' => 'usuario invalido',
        ], 400);
    }
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
