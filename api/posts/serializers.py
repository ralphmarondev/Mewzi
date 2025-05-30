from rest_framework import serializers
from .models import Post

class PostSerializer(serializers.ModelSerializer):
    owner_username = serializers.CharField(source='owner.username', read_only=True)
    owner_image = serializers.ImageField(source='owner.image', read_only=True)
    image = serializers.ImageField(required=False)

    class Meta:
        model = Post 
        fields = '__all__'
        read_only_fields = ['owner']

    def create(self, validated_data):
        user = self.context['request'].user
        validated_data['owner'] = user 
        return super().create(validated_data)
