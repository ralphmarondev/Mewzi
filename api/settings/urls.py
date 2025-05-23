from django.urls import path
from .views import *

urlpatterns = [
    path('roles/', RoleView.as_view()),
    path('update-role/<int:pk>/', RoleView.as_view()),
    path('delete-role/<int:pk>/', RoleView.as_view())
]
