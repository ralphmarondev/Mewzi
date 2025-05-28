from rest_framework import serializers
from .models import Post

class PostSerializer(serializers.ModelSerializer):
    owner_username = serializers.CharField(source='owner.username', read_only=True)
    owner_image = serializers.ImageField(source='owner.image', read_only=True)

    class Meta:
        model = Post 
        fields = '__all__'
