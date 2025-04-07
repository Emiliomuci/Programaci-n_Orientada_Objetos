class PuntoDeVentas:
    def __init__(self):
        self.productos=[]
        self.carrito=[]
        self.ventas_del_dia=[]
    
    def agregar_producto(self, producto):
        self.productos.append(producto)
    
    def mostrar_productos(self):
        print("\nLista de productos:")
        for idx, producto in enumerate(self.productos, start=1):
            print(f"{idx}. {producto.nombre} \tstock: {producto.stock} \tprecio: ${producto.precio}")
    
    def realizar_venta(self):
        print("\nCarrito de compras")
        while True:
            self.mostrar_productos()
            opcion=input("\nTerminar ventas (TV) o agregar otro producto (AP): ").upper()
            
            if opcion=='TV':
                break
            elif opcion=='AP':
                id_producto=input("Ingresar código de producto: ")
                producto=next((p for p in self.productos if p.id==id_producto), None)
                if producto and producto.stock>0:
                    cantidad=int(input("Cantidad: "))
                    if cantidad<=producto.stock:
                        total=cantidad*producto.precio
                        self.carrito.append((producto, cantidad, total))
                        producto.stock-=cantidad
                        print(f"Total a pagar: ${total:.2f}")
                    else:
                        print("*** Error: ya no hay stock disponible ***")
                else:
                    print("*** Error: producto no encontrado o sin stock disponible ***")
            else:
                print("*** Opción no válida ***")

        tventa=sum(item[2] for item in self.carrito)
        tarticulos=sum(item[1] for item in self.carrito)
        self.ventas_del_dia.append((len(self.carrito), tventa, tarticulos))
        self.carrito.clear()
        print(f"\nVenta realizada exitosamente:\nImporte total de ventas: ${tventa:.2f}\nCantidad de artículos: {tarticulos}\n")

    def reporte_ventas(self):
        print("\nReporte de ventas del día:")
        tventas=len(self.ventas_del_dia)
        timporte=sum(venta[1] for venta in self.ventas_del_dia)
        tarticulos=sum(venta[2] for venta in self.ventas_del_dia)
        tpiezas=sum(venta[0] for venta in self.ventas_del_dia)
        
        print(f"Cantidad de ventas: {tventas}")
        print(f"Importe total de ventas: ${timporte:.2f}")
        print(f"Cantidad total de artículos: {tarticulos}")
        print(f"Total de piezas vendidas: {tpiezas}")