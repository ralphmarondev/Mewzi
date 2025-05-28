from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status 
from rest_framework.permissions import IsAuthenticated
from .models import Post
from .serializers import PostSerializer

class PostListCreateView(APIView):
    permission_classes = [IsAuthenticated]

    def get(self, request):
        posts = Post.objects.filter(is_deleted=False).order_by('-create_date')
        serializer = PostSerializer(posts, many=True)
        return Response(serializer.data)
    
    def post(self, request):
        data = request.data.copy()
        data['owner'] = request.user.id
        serializer = PostSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
    
class PostDetailView(APIView):
    permission_classes = [IsAuthenticated]

    def get_object(self, pk):
        try:
            return Post.objects.get(pk=pk, is_deleted=False)
        except Post.DoesNotExist:
            return None
        
    def get(self, request, pk):
        post = self.get_object(pk)
        if not post:
            return Response(
                {'detail': 'Not found'},
                status=status.HTTP_404_NOT_FOUND
            )
        serializer = PostSerializer(post)
        return Response(serializer.data)
    
    def delete(self, request, pk):
        post = self.get_object(pk)
        if not post:
            return Response({'detail': 'Not found'}, status=status.HTTP_404_NOT_FOUND)
        post.is_deleted = True
        post.save()
        return Response(status=status.HTTP_204_NO_CONTENT)
    