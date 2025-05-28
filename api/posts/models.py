from django.db import models
from users.models import Users

class Post(models.Model):
    id = models.AutoField(primary_key=True)
    image = models.ImageField(upload_to='posts/',blank=True, null=True)
    caption = models.TextField(blank=True, null=True)
    create_date = models.DateTimeField(auto_now_add=True)
    update_date = models.DateTimeField(auto_now=True)
    is_deleted = models.BooleanField(default=False)

    owner = models.ForeignKey(
        Users,
        on_delete=models.CASCADE,
        related_name='posts'
    )

    def __str__(self):
        return f'{self.owner.username} post'
