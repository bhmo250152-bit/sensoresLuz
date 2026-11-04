# Actividad 3 - U3 | Uso de sensor de luz

App Android (Kotlin) que usa el sensor de luz (TYPE_LIGHT) para alternar entre modo oscuro y claro.

- Luz < 50: modo oscuro (fondo negro, texto blanco)
- Luz > 500: modo claro (fondo blanco, texto negro)
- Entre 50 y 500: conserva el modo actual

## Abrir
Android Studio > File > Open > carpeta SensorLuz. Esperar a que termine Gradle Sync y ejecutar.

## Probar en el emulador
Extended controls (...) > Virtual sensors > Additional sensors > Light. Probar con 10, 300 y 800.
