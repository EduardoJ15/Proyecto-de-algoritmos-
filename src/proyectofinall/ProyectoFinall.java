/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinall;

import java.util.Scanner;

/**
 *
 * @author MONKY
 */
public class ProyectoFinall {
    
    
    public static void proyectoVenta() {
        // Objeto para leer los datos ingresados por consola
        Scanner entradaTeclado = new Scanner(System.in);

        // Variables del menú principal
        int opcionMenu;

        // Variables para registrar una venta
        int totalProductosVenta;
        int cantidadActualProducto;
        int indiceProducto;
        int opcionFormaPago;

        String codigoProducto;
        String nombreProducto;
        String descripcionFormaPago = "";

        double precioUnitario;
        double subtotalProducto;
        double subtotalVenta;
        double porcentajeDescuento;
        double montoConDescuento;
        double impuestoIVA;
        double totalAPagar;
        double efectivoRecibido = 0;
        double cambioDevuelto = 0;

        // Variables acumuladoras para caja y estadísticas generales
        int acumuladorVentasRealizadas = 0;
        int acumuladorProductosVendidos = 0;
        int contadorVentasEfectivo = 0;
        int contadorVentasTarjeta = 0;
        int contadorVentasTransferencia = 0;

        double acumuladorTotalVendido = 0;
        double promedioVenta;
        double ventaMayorValor = 0;
        double ventaMenorValor = 0;

        // Bandera de control para la primera venta (para el cálculo de mayor y menor)
        int banderaPrimeraVenta = 0;

        // Menú principal mediante bucle do-while
        do {
            System.out.println("\n===== SISTEMA DE VENTAS =====");
            System.out.println("1. Registrar una venta");
            System.out.println("2. Consultar caja");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion:");
            opcionMenu = entradaTeclado.nextInt();

            // Validación de la opción del menú principal
            while (opcionMenu < 1 || opcionMenu > 4) {
                System.out.println("Opcion incorrecta.");
                System.out.println("Ingrese una opcion del 1 al 4:");
                opcionMenu = entradaTeclado.nextInt();
            }

            // Selección de opciones mediante switch
            switch (opcionMenu) {
                case 1:
                    // Registrar una venta: inicializar variables de la venta actual
                    subtotalVenta = 0;
                    porcentajeDescuento = 0;
                    montoConDescuento = 0;
                    impuestoIVA = 0;
                    totalAPagar = 0;
                    efectivoRecibido = 0;
                    cambioDevuelto = 0;

                    // Ingreso de la cantidad de productos distintos para la venta
                    System.out.println("Ingrese la cantidad de productos:");
                    totalProductosVenta = entradaTeclado.nextInt();

                    // Validación de la cantidad de productos
                    while (totalProductosVenta <= 0) {
                        System.out.println("La cantidad debe ser mayor que cero.");
                        System.out.println("Ingrese nuevamente la cantidad:");
                        totalProductosVenta = entradaTeclado.nextInt();
                    }

                    // Ingreso de los productos mediante ciclo for
                    for (indiceProducto = 1; indiceProducto <= totalProductosVenta; indiceProducto++) {
                        System.out.println("--- Producto " + indiceProducto + " ---");
                        System.out.println("Ingrese el codigo del producto:");
                        codigoProducto = entradaTeclado.next();

                        System.out.println("Ingrese el nombre del producto:");
                        nombreProducto = entradaTeclado.next();

                        System.out.println("Ingrese el precio del producto:");
                        precioUnitario = entradaTeclado.nextDouble();

                        // Validación del precio unitario
                        while (precioUnitario <= 0) {
                            System.out.println("El precio debe ser mayor que cero.");
                            System.out.println("Ingrese nuevamente el precio:");
                            precioUnitario = entradaTeclado.nextDouble();
                        }

                        System.out.println("Ingrese la cantidad del producto:");
                        cantidadActualProducto = entradaTeclado.nextInt();

                        // Validación de la cantidad del producto
                        while (cantidadActualProducto <= 0) {
                            System.out.println("La cantidad debe ser mayor que cero.");
                            System.out.println("Ingrese nuevamente la cantidad:");
                            cantidadActualProducto = entradaTeclado.nextInt();
                        }

                        // Cálculo del subtotal del producto actual
                        subtotalProducto = precioUnitario * cantidadActualProducto;

                        // Acumulación del subtotal general de la venta
                        subtotalVenta = subtotalVenta + subtotalProducto;

                        // Acumulación de la cantidad total de unidades vendidas
                        acumuladorProductosVendidos = acumuladorProductosVendidos + cantidadActualProducto;

                        // Muestra de datos del producto ingresado
                        System.out.println("Codigo: " + codigoProducto);
                        System.out.println("Nombre: " + nombreProducto);
                        System.out.println("Subtotal del producto: Q" + subtotalProducto);
                    }

                    // Cálculo del descuento basado en escalas de subtotal
                    if (subtotalVenta < 200) {
                        porcentajeDescuento = 0;
                    } else if (subtotalVenta < 500) {
                        porcentajeDescuento = subtotalVenta * 0.05;
                    } else if (subtotalVenta < 1000) {
                        porcentajeDescuento = subtotalVenta * 0.08;
                    } else {
                        porcentajeDescuento = subtotalVenta * 0.10;
                    }

                    // Cálculo del monto después de aplicar el descuento
                    montoConDescuento = subtotalVenta - porcentajeDescuento;

                    // Cálculo del IVA (12%)
                    impuestoIVA = montoConDescuento * 0.12;

                    // Cálculo del total definitivo a pagar
                    totalAPagar = montoConDescuento + impuestoIVA;

                    // Muestra de los cálculos detallados de la venta
                    System.out.println("\n===== CALCULO DE LA VENTA =====");
                    System.out.println("Subtotal: Q" + subtotalVenta);
                    System.out.println("Descuento: Q" + porcentajeDescuento);
                    System.out.println("Monto con descuento: Q" + montoConDescuento);
                    System.out.println("IVA: Q" + impuestoIVA);
                    System.out.println("Total a pagar: Q" + totalAPagar);

                    // Selección de la forma de pago
                    System.out.println("\n===== FORMA DE PAGO =====");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Tarjeta");
                    System.out.println("3. Transferencia");
                    System.out.println("Ingrese la forma de pago:");
                    opcionFormaPago = entradaTeclado.nextInt();

                    // Validación de la opción de forma de pago
                    while (opcionFormaPago < 1 || opcionFormaPago > 3) {
                        System.out.println("Opcion incorrecta.");
                        System.out.println("Ingrese una opcion del 1 al 3:");
                        opcionFormaPago = entradaTeclado.nextInt();
                    }

                    // Lógica según la forma de pago seleccionada
                    switch (opcionFormaPago) {
                        case 1:
                            descripcionFormaPago = "Efectivo";
                            System.out.println("Ingrese el efectivo recibido:");
                            efectivoRecibido = entradaTeclado.nextDouble();

                            // Validación de efectivo suficiente
                            while (efectivoRecibido < totalAPagar) {
                                System.out.println("Efectivo insuficiente.");
                                System.out.println("Ingrese nuevamente el efectivo:");
                                efectivoRecibido = entradaTeclado.nextDouble();
                            }

                            cambioDevuelto = efectivoRecibido - totalAPagar;
                            contadorVentasEfectivo++;
                            break;

                        case 2:
                            descripcionFormaPago = "Tarjeta";
                            contadorVentasTarjeta++;
                            break;

                        case 3:
                            descripcionFormaPago = "Transferencia";
                            contadorVentasTransferencia++;
                            break;
                    }

                    // Acumulación general de ventas realizadas
                    acumuladorVentasRealizadas++;

                    // Acumulación monetaria del dinero total vendido
                    acumuladorTotalVendido = acumuladorTotalVendido + totalAPagar;

                    // Registro de la venta mayor y venta menor
                    if (banderaPrimeraVenta == 0) {
                        ventaMayorValor = totalAPagar;
                        ventaMenorValor = totalAPagar;
                        banderaPrimeraVenta = 1;
                    } else {
                        if (totalAPagar > ventaMayorValor) {
                            ventaMayorValor = totalAPagar;
                        }
                        if (totalAPagar < ventaMenorValor) {
                            ventaMenorValor = totalAPagar;
                        }
                    }

                    // Resumen final de la venta exitosa
                    System.out.println("\n===== RESUMEN DE LA VENTA =====");
                    System.out.println("Cantidad de productos: " + totalProductosVenta);
                    System.out.println("Subtotal: Q" + subtotalVenta);
                    System.out.println("Descuento: Q" + porcentajeDescuento);
                    System.out.println("IVA: Q" + impuestoIVA);
                    System.out.println("Total a pagar: Q" + totalAPagar);
                    System.out.println("Forma de pago: " + descripcionFormaPago);

                    if (opcionFormaPago == 1) {
                        System.out.println("Efectivo recibido: Q" + efectivoRecibido);
                        System.out.println("Cambio: Q" + cambioDevuelto);
                    }

                    System.out.println("Venta registrada correctamente.");
                    break;

                case 2:
                    // Consultar caja actual
                    System.out.println("\n===== CONSULTA DE CAJA =====");
                    System.out.println("Ventas realizadas: " + acumuladorVentasRealizadas);
                    System.out.println("Productos vendidos: " + acumuladorProductosVendidos);
                    System.out.println("Total vendido: Q" + acumuladorTotalVendido);
                    System.out.println("Ventas en efectivo: " + contadorVentasEfectivo);
                    System.out.println("Ventas con tarjeta: " + contadorVentasTarjeta);
                    System.out.println("Ventas por transferencia: " + contadorVentasTransferencia);
                    break;

                case 3:
                    // Mostrar estadísticas detalladas
                    if (acumuladorVentasRealizadas == 0) {
                        System.out.println("\nNo existen ventas registradas.");
                    } else {
                        promedioVenta = acumuladorTotalVendido / acumuladorVentasRealizadas;

                        System.out.println("\n===== ESTADISTICAS =====");
                        System.out.println("Numero total de ventas: " + acumuladorVentasRealizadas);
                        System.out.println("Cantidad total de productos vendidos: " + acumuladorProductosVendidos);
                        System.out.println("Total de dinero vendido: Q" + acumuladorTotalVendido);
                        System.out.println("Promedio por venta: Q" + promedioVenta);
                        System.out.println("Ventas en efectivo: " + contadorVentasEfectivo);
                        System.out.println("Ventas con tarjeta: " + contadorVentasTarjeta);
                        System.out.println("Ventas por transferencia: " + contadorVentasTransferencia);
                        System.out.println("Venta de mayor valor: Q" + ventaMayorValor);
                        System.out.println("Venta de menor valor: Q" + ventaMenorValor);
                    }
                    break;

                case 4:
                    // Salir del sistema
                    System.out.println("\nSaliendo del sistema de ventas. ¡Hasta luego!");
                    break;
            }

        } while (opcionMenu != 4);

        entradaTeclado.close();
    }

    public static void main(String[] args) {
        proyectoVenta();
    }
}
