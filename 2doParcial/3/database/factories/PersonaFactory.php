<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

class PersonaFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array
     */
    public function definition()
    {
        return [
            'nombres' => $this->faker->name(),
            'apellidos' => $this->faker->lastName(),
            'sexo' => $this->faker->randomElement(['Masculino', 'Femenino']),
            'estatura' => $this->faker->numberBetween(1.50, 2.50),
            
        ];
    }
}
