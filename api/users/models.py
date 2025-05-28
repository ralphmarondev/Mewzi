from django.db import models
from settings.models import Roles
from django.contrib.auth.models import AbstractUser

GENDER_CHOICES = [('Male', 'Male'), ('Female', 'Female')]
STATUS_CHOICES = [('Active', 'Active'), ('Suspend', 'Suspend'), ('Pending', 'Pending')]

class Users(AbstractUser):
    id = models.AutoField(primary_key=True)
    role = models.ForeignKey(Roles, on_delete=models.CASCADE, db_column='role_id')
    username = models.CharField(max_length=200, blank=True, null=True, unique=True)
    email = models.EmailField(max_length=200, blank=True, null=True, unique=True)
    first_name = models.CharField(max_length=200, blank=True, null=True)
    last_name = models.CharField(max_length=200, blank=True, null=True)
    password = models.CharField(max_length=200, blank=True, null=True)
    mobile_no = models.CharField(max_length=200, blank=True, null=True)
    gender = models.CharField(max_length=100, choices=GENDER_CHOICES, blank=True, null=True)
    status = models.CharField(max_length=100, choices=STATUS_CHOICES, blank=True, null=True)
    image = models.ImageField(upload_to='users/', blank=True, null=True)
    approved_date = models.DateTimeField(blank=True, null=True)
    update_date = models.DateTimeField(auto_now=True)
    is_deleted = models.BooleanField(default=False)
    create_date = models.DateTimeField(auto_now=True)

    USERNAME_FIELD = 'username'
    REQUIRED_FIELDS = []
