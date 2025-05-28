from django.contrib import admin
from django.urls import path, include
from django.conf.urls.static import static 
from .import settings

urlpatterns = [
    path('api/', include('users.urls')),
    path('api/', include('settings.urls'))
] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
