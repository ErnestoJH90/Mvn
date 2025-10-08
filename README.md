Este pipeline de Azure DevOps está diseñado para automatizar el proceso de compilación, ejecución y análisis estático de código Java usando Maven y SonarQube, todo al detectar cambios en la rama yml.

🔧 Pasos del pipeline
Orden	Acción	Descripción.

1️⃣	Mostrar IP	Ejecuta ip addr show para mostrar las interfaces de red del agente (útil para depurar conectividad).

2️⃣	Mostrar rama	Imprime la rama actual que activó el pipeline ($(Build.SourceBranch)).

3️⃣	Checkout	Descarga el código del repositorio (git clone).

4️⃣	Ver versión de Maven	Ejecuta mvn --version para confirmar que Maven está instalado y accesible.

5️⃣	Compilar y ejecutar la app	Usa Maven para compilar el proyecto y luego ejecuta la clase App, redireccionando la salida a Reports.txt.

6️⃣	Verificar acceso a SonarQube	Hace hasta 3 intentos con curl para verificar que SonarQube está corriendo. Si no responde, el pipeline falla aquí.

7️⃣	Análisis con SonarQube	Si el paso anterior tuvo éxito, ejecuta mvn verify sonar:sonar para analizar el código con SonarQube usando el token seguro AZURE_SONAR_TOKEN.

8️⃣	Publicar reporte	Sube Reports.txt como artefacto del pipeline para que puedas descargarlo desde la interfaz de Azure DevOps.

🧩 ¿Qué necesitas para que funcione?

✅ Tener un agente auto-hospedado en línea y conectado a LocalAgent.

✅ El archivo pom.xml debe estar correctamente configurado.

✅ La carpeta KtJenkins debe existir y tener el código Java.

✅ El token AZURE_SONAR_TOKEN debe tener permisos en SonarQube.

✅ SonarQube debe estar accesible desde la red del agente.

1. Trigger

Se activa automáticamente cuando hay cambios en cualquier archivo bajo la carpeta yml (o archivo yml).

2. Pool

  name: LocalAgent # Este es el nombre de tu pool creado en Azure DevOps

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
