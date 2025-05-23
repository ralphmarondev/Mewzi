from rest_framework.permissions import IsAuthenticated
from rest_framework.response import Response
from rest_framework.views import APIView
from rest_framework import status
from .serializers import *
from .models import *

class RoleView(APIView):
    permission_classes=[IsAuthenticated]
    def get(self, request):
        request = Roles.objects.filter(is_deleted=False).order_by('-id')
        serializer = RoleSerializer(request, many=True)
        return Response(serializer.data)

    def post(self, request):
        data = request.data
        serializer = RoleSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def put(self, request, pk):
        try:
            role = Roles.objects.get(pk=pk, is_deleted=False)
        except Roles.DoesNotExist:
            return Response({'error': 'Role not found'}, status=status.HTTP_404_NOT_FOUND)
        
        data = request.data
        serializer = RoleSerializer(role, data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

