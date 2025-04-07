from ClaseProducto import Producto
from ClasePuntoDeVentas import PuntoDeVentas

if __name__ == "__main__":
    punto_de_ventas=PuntoDeVentas()
    punto_de_ventas.agregar_producto(Producto("1", "Silla de madera", 550.50, 5))
    
    while True:
        print("\nCarrito de compras\n")
        opcion=input("A. Listar productos\nB. Agregar producto\nC. Realizar venta\nS. Salir\n\nElige una opción: ").upper()
        
        if opcion=="A":
            punto_de_ventas.mostrar_productos()
        elif opcion=="B":
            id=input("\nID: ")
            nombre=input("Nombre del producto: ")
            precio=float(input("Precio: "))
            stock=int(input("Stock: "))
            punto_de_ventas.agregar_producto(Producto(id, nombre, precio, stock))
            print("\n** Producto agregado exitosamente en el carrito **")
        elif opcion=="C":
            punto_de_ventas.realizar_venta()
        elif opcion=="S":
            punto_de_ventas.reporte_ventas()
            print("\nSaliendo del programa...")
            break
        else:
            print("Opción inválida. Por favor, selecciona una opción válida.")