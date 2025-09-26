KT JENKINS SONARQUBE 
  Este Jenkinsfile define un pipeline de CI/CD para un proyecto Maven en Jenkins, con los siguientes pasos:

      ejecutando en LinuxKt:
      Ejecuta ip addr show para mostrar información de red (solo funciona en Linux).
      
      Verify Branch:
      Imprime el nombre de la rama actual usando la variable de entorno ${env.GIT_BRANCH}.
      
      Checkout:
      Clona el repositorio desde GitHub usando la rama LinuxKt y credenciales específicas.
      
      Mvn Version:
      Muestra la versión de Maven instalada.
      
      Build:
      Entra al directorio KtJenkins, compila el proyecto con Maven y ejecuta la aplicación Java, guardando la salida en             Reports.txt.
      
      SonarQube Analysis:
      Realiza análisis de calidad de código con SonarQube usando Maven dentro del directorio KtJenkins.
      
      Delivery:
      Archiva el archivo Reports.txt como artefacto del build.
      
      Post:
      Limpia el workspace al finalizar el pipeline, sin importar el resultado.
      
      En resumen:
      Compila y analiza el proyecto Java con Maven y SonarQube, guarda el resultado y limpia el entorno al final.
      ERNESTO JIMENEZ HUITRON

