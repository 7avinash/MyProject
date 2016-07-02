from rest_framework import serializers
from .models import Post

class PostSerializer(serializers.ModelSerializer):
    user = serializers.SlugRelatedField(read_only=True, slug_field="username")
    institute = serializers.SlugRelatedField(read_only=True, slug_field="name")
    user = serializers.SlugRelatedField(read_only=True, slug_field="username")
    class Meta:
        model=Post
        fields = ('user', 'title', 'content', 'image', 'id', "institute")
