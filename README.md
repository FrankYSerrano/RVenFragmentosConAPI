La aplicación móvil Android desarrollada consta de dos actividades principales.

1) La primera actividad presenta una lista de ítems utilizando un RecyclerView, que obtiene los datos desde una API REST llamada LISTARX.
Los ítems mostrados en esta lista representan una colección de datos recuperados en tiempo real desde el servidor.
Al seleccionar un ítem en la lista, se navega a la segunda actividad.

2) La seunda actividad muestra los detalles del ítem seleccionado previamente.
Esta información detallada se obtiene mediante una segunda API REST llamada DETALLEX.

Para mejorar la resiliencia de la aplicación y asegurar el acceso a los datos incluso sin conexión a Internet, se ha implementado una base de datos
local utilizando ROOM. Los usuarios puedan acceder a la lista de ítems y sus detalles incluso cuando no disponen de una conexión a Internet.
Esto se logra mediante la sincronización de datos cuando la conectividad está disponible y el acceso a la caché local en su ausencia,
garantizando una experiencia de usuario fluida y continua.

La aplicación ha sido desarrollada siguiendo la arquitectura Model-View-ViewModel (MVVM).
En esta arquitectura:

El Model se encarga de gestionar los datos (obtención desde las APIs REST y la gestión de la base de datos local utilizando ROOM).
El View es responsable de la interfaz de usuario, mostrando la lista de ítems y los detalles correspondientes.
El ViewModel actúa como un intermediario entre el Model y el View, manejando la lógica de la UI y actualizando los datos del View sin interactuar
directamente con el Model.
