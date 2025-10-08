1. Trigger

Se activa automáticamente cuando hay cambios en cualquier archivo bajo la carpeta yml (o archivo yml).

2. Pool

Usa una máquina virtual Ubuntu actualizada (ubuntu-latest) para ejecutar las tareas.

3. Steps (pasos):

Mostrar IP del agente

Ejecuta ip addr show para ver la configuración de red del agente que ejecuta el pipeline (útil para debug).

Mostrar rama del build

Imprime en la consola el nombre de la rama que disparó el build.

Checkout código

Descarga el código fuente del repositorio para trabajar con él.

Configurar Java 21

Usa la tarea UseJava@1 para asegurarse de que Java 21 está disponible (aunque ubuntu-latest ya lo tiene).

Mostrar versiones

Ejecuta comandos para mostrar la versión de Java y Maven instalados (para validar entorno).

Compilar y ejecutar la app

Entra a la carpeta KtJenkins

Ejecuta mvn clean package para compilar el proyecto y crear el JAR.

Ejecuta la clase principal com.KtJenkins.app.App y redirige su salida al archivo Reports.txt.

Preparar SonarQube

Configura el análisis de SonarQube con los parámetros del proyecto.

Ejecutar SonarQube

Ejecuta el análisis de código con Maven y el plugin de SonarQube, apuntando a tu servidor SonarQube.
Publicar reporte

Publica el archivo Reports.txt como artefacto para que puedas descargarlo después del build.

En resumen:

Este pipeline:

Se activa con cambios en archivos YAML.

Prepara un entorno Ubuntu con Java 21 y Maven.

Compila y ejecuta tu aplicación Java.

Analiza el código con SonarQube.

Guarda el resultado de la ejecución en un reporte para revisión.
