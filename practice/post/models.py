from django.db import models
from user_groups.models import UserDetail

# Create your models here.

class Post(models.Model):
    user = models.ForeignKey(UserDetail, related_name="post_owner")
    institute = models.ForeignKey(Institute)
    title = models.CharField(max_length=120)
    content = models.TextField(blank=True)
    image = models.FileField(null=True, blank=True)

    def __str__(self):
        return (%s:%s) %(self.user.name, self.title)
