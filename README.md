# Calculadora de Liquidación de Sueldo

Este proyecto permite calcular una liquidación de sueldo en base al sueldo base, días trabajados y bonos del empleado. A continuación, se detallan las funcionalidades y validaciones:

## Entrada de Datos

- Sueldo Base: Ingrese el sueldo base del empleado.
- Días Trabajados: Ingrese la cantidad de días trabajados en el mes.
- Bonos: Ingrese el monto de bonos otorgados al empleado.

## Cálculos

- Sueldo del Mes: Se calcula como el sueldo base dividido por 30, multiplicado por los días trabajados.
- Sueldo Imponible: Se suma el Sueldo del Mes más los bonos.
- Total Imponible: Al calcular el sueldo imponible, se calcula además:
  - Monto AFP (13% del sueldo imponible).
  - Monto Salud (7% del sueldo imponible).
  - Total Descuentos: La suma de la AFP y el monto de salud.
  - Total a Pagar: El sueldo imponible menos el total de descuentos.

## Validaciones

Se realizan las siguientes validaciones:

- Campos Obligatorios: El sueldo base y los días trabajados son campos obligatorios.
- Rangos de Valores:
  - Sueldo Base debe ser mayor o igual a $326,500.
  - Días Trabajados deben estar en el rango de 0 a 30.
  - Bonos no deben ser superiores a 0.5 veces el sueldo base ingresado.

## Cálculo de Sueldo Mensual

- Para calcular el Sueldo Mensual, se debe haber ingresado información válida para el sueldo base y los días trabajados.
- El cálculo se muestra en formato: "SUELDO MENSUAL: $999,999".

## Cálculo de Liquidación

- Para calcular la Liquidación, se debe haber calculado el Sueldo Mensual previamente.
- Se muestra el Sueldo Imponible calculado en el TextView correspondiente.
- Luego se realizan los cálculos de AFP, Salud, Total Descuentos y Total a Pagar.

## Función de Reinicio

Se incluye una función de reinicio que permite limpiar el formulario completo y comenzar de nuevo.

##Vista

![Vista](https://github.com/ClaudioVergara2/LiquidacionSueldo/blob/main/Prototipo.jpg)
