from django.db import models
from django.contrib.auth.models import User
from user_groups.models import UserDetail, Institute


# Create your models here.

class Post(models.Model):
    user = models.ForeignKey(User, related_name="post_owner")
    institute = models.ForeignKey(Institute)
    title = models.CharField(max_length=120)
    content = models.TextField(blank=True)
    image = models.FileField(null=True, blank=True)

    def __str__(self):
        return ('%s:%s') %(self.user.username, self.title)
