Feature: RegistrarNotas
  @Registrar
  Scenario Outline: Crear una tarea de notas
    Given que la app: whenDo esta abierta
    When agrego una nueva tarea
    And registrar Un Titulo: "<titulo>"
    And registrar Una Descripcion: "<descripcion>"
    And hago click en guardar
    And Seleccionar el tipo de orden
    And seleccionar el orden alfabetico
    Then la tarea "Deporte" deberia ser mostrado
    Examples:
      |titulo     | descripcion  |
      |Deporte    |Futbol y voley|