from django.db import models

class Roles(models.Model):
    id = models.AutoField(primary_key=True)
    role = models.CharField(max_length=200, blank=True, null=True)
    is_deleted = models.BooleanField(default=False)
    create_date = models.DateTimeField(auto_now=True)

