KT JENKINS SONARQUBE 
Este Jenkinsfile define un pipeline de CI/CD para un proyecto Maven en Jenkins.

MASTER
Resumen de lo que hace:
  Checkout: Clona el repositorio desde GitHub usando la rama master.
  
  Mvn Version: Muestra la versión de Maven instalada (usa bat porque está pensado para Windows).
  
  Build:
  Entra al directorio KtJenkins.
  Compila el proyecto con Maven (mvn clean package).
  Ejecuta la aplicación Java y guarda la salida en Reports.txt.
  
  Delivery: Archiva el archivo Reports.txt como artefacto del build.
  
  Post: Limpia el workspace al finalizar, sin importar si el pipeline falló o tuvo éxito.

  En resumen:
  Compila y ejecuta una app Java con Maven, guarda el resultado y limpia el entorno al final.

  ERNESTO JIMENEZ HUITRON
  