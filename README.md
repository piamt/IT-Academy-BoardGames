# IT-Academy-BoardGames

## Biblioteca de Juegos de Mesa: Administración de Inventario

### Descripción del Proyecto: 
Nos piden desarrollar una aplicación que gestione una biblioteca de juegos de mesa, permitiendo administrar un inventario de diferentes tipos de juegos.

### Requisitos del Sistema:

#### Juegos de Mesa con Categorías y Características
- Cada juego de mesa tendrá un identificador único, nombre, dificultad y precio.
  Los juegos pueden ser de diferentes categorías, por ejemplo, estrategia, azar, rol.
- Cada categoría debe implementar la misma funcionalidad base, aunque cada
tipo puede tener características particulares.

#### Inventario y Precio Final con IVA
- Cada juego cuenta con una cantidad en inventario.
- El precio de cada juego debe incluir un IVA del 10%.

#### Gestión de Excepciones
Deben considerarse situaciones específicas que deban controlarse correctamente mediante excepciones personalizadas.

#### Funcionalidades Mínimas:
- Crear un nuevo juego de mesa y añadirlo al inventario.
- Actualizar la cantidad disponible de un juego en el inventario.
- Mostrar todos los juegos disponibles, incluyendo el precio final con IVA.
- Buscar un juego específico por su nombre.
- Eliminar un juego del inventario.
- Filtrar juegos según su categoría o dificultad.

#### Requisitos de Implementación:
- Uso de herencia y polimorfismo para representar las distintas categorías de juegos.
- Aplicación de lambdas y streams para filtrar juegos según dificultad o categoría.
- Empleo de una clase genérica que gestione el inventario, permitiendo almacenar y recuperar juegos.
- Uso de anotaciones
- El proyecto debe estar bien estructurado a nivel de paquetes, enfocándose en el concepto de responsabilidad única de las clases y con una buena gestión de excepciones.

#### Pruebas Unitarias (JUnit):
Implementa pruebas unitarias que verifiquen las funcionalidades mínimas del sistema:
- Creación de un juego y adición al inventario.
